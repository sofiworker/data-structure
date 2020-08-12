package me.sofiworker.datastructure.tree;

import java.io.*;
import java.util.*;

/**
 * @author sofiworker
 * @date 2020/8/11
 * 哈夫曼编码
 */
public class HuffmanCode {

    static class Node implements Comparable<Node> {
        Byte data;
        int weight;
        Node left;
        Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
//        String str = "i like like like java do you like a java";
//        byte[] bytes = huffmanZip(str.getBytes());
//        System.out.println(Arrays.toString(bytes));
//
//        System.out.println("原来的字符串："+ new String(unzip(bytes, codeMap)));

        String source = "C:\\Users\\sofiworker\\Desktop\\Aimer.png";
        String dest = "C:\\Users\\sofiworker\\Desktop\\Aimer1.zip";
//        zipFile(source, dest);
        unzipFile(dest, "C:\\Users\\sofiworker\\Desktop\\aa.png");
    }

    private static void zipFile(String sourcePath, String destPath) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            inputStream = new FileInputStream(sourcePath);
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            byte[] zip = huffmanZip(b);
            outputStream = new FileOutputStream(destPath);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(zip);
            objectOutputStream.writeObject(codeMap);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
                objectOutputStream.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void unzipFile(String sourcePath, String destPath) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            inputStream = new FileInputStream(sourcePath);
            objectInputStream = new ObjectInputStream(inputStream);
            byte[] bytes = (byte[]) objectInputStream.readObject();
            Map<Byte, String> map = (Map<Byte, String>) objectInputStream.readObject();
            byte[] unzip = unzip(bytes, map);
            outputStream = new FileOutputStream(destPath);
            outputStream.write(unzip);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
                objectInputStream.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static byte[] unzip(byte[] bytes, Map<Byte, String> codeMap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            boolean flag = (i == bytes.length - 1);
            sb.append(byteToString(!flag, bytes[i]));
        }
        Map<String, Byte> reverseCodeMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : codeMap.entrySet()) {
            reverseCodeMap.put(entry.getValue(), entry.getKey());
        }
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String key = sb.substring(i, i+count);
                b = reverseCodeMap.get(key);
                if (b != null) {
                    flag = false;
                }else {
                    count++;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] result = new byte[list.size()];
        int i = 0;
        for (Byte aByte : list) {
            result[i++] = aByte;
        }
        return result;
    }

    private static String byteToString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        }else {
            return str;
        }
    }

    private static byte[] huffmanZip(byte[] bytes) {
        Node root = createTree(bytes);
        getCode(root, "", stringBuilder);
        return zip(bytes, codeMap);
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> codeMap) {
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(codeMap.get(aByte));
        }
        int len;
        if (sb.length() % 8 == 0) {
            len = sb.length() / 8;
        }else {
            len = sb.length() / 8 + 1;
        }
        byte[] result = new byte[len];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String byteStr;
            if (i + 8 > sb.length()) {
                byteStr = sb.substring(i);
            }else {
                byteStr = sb.substring(i, i + 8);
            }
            result[index] = (byte) Integer.parseInt(byteStr, 2);
            index++;
        }
        return result;
    }

    // 生成哈夫曼树
    private static Node createTree(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (byte aByte : bytes) {
            if (!map.containsKey(aByte)) {
                map.put(aByte, 1);
            }else {
                map.put(aByte, map.get(aByte)+1);
            }
        }
        map.forEach((aByte, integer) -> {
            nodes.add(new Node(aByte, integer));
        });

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private static final Map<Byte, String> codeMap = new HashMap<>();
    private static final StringBuilder stringBuilder = new StringBuilder();

    private static void getCode(Node node, String val, StringBuilder sb) {
        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(val);
        if (node != null) {
            if (node.data == null) {
                getCode(node.left, "0", stringBuilder);
                getCode(node.right, "1", stringBuilder);
            }else {
                codeMap.put(node.data, new String(stringBuilder));
            }
        }
    }

    private static void preOrder(Node node) {
        System.out.println(node);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }
}
