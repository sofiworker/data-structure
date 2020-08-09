package me.sofiworker.datastructure.hash;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/9
 */
public class HashTest {

    // 人员信息
    static class Emp {
        public int id;
        public String name;
        public Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class EmpLinkedList {
        private Emp head;

        public void add(Emp emp) {
            if (head == null) {
                head = emp;
                return;
            }
            Emp cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = emp;
        }

        public void list(int no) {
            if (head == null) {
                System.out.println("第"+no+"条链表为空");
                return;
            }
            Emp cur = head;
            System.out.print("第"+no+"条链表信息为：");
            while (true) {
                System.out.print(cur );
                if (cur.next == null) {
                    break;
                }
                cur = cur.next;
            }
            System.out.println();
        }

        public Emp findEmpById(int id) {
            if (head == null) {
                System.out.println("链表为空");
                return null;
            }
            Emp cur = head;
            while (true) {
                if (cur.id == id) {
                    return cur;
                }
                if (cur.next == null) {
                    return null;
                }
                cur = cur.next;
            }
        }
    }

    static class Hash {
        private EmpLinkedList[] data;
        private int size;

        public Hash(int size) {
            this.size = size;
            data = new EmpLinkedList[size];
            for (int i = 0; i < data.length; i++) {
                data[i] = new EmpLinkedList();
            }
        }

        public void add(Emp emp) {
            // 根据 id 得到该员工应该添加到哪条链表
            int index = hashFun(emp.id);
            data[index].add(emp);
        }

        public void list() {
            for (int i = 0; i < data.length; i++) {
                data[i].list(i);
            }
        }

        public Emp findEmp(int no) {
            return data[hashFun(no)].findEmpById(no);
        }

        // 编写散列函数，取模法
        private int hashFun(int id) {
            return id % size;
        }
    }

    public static void main(String[] args) {
        Hash hash = new Hash(7);
        Emp emp1 = new Emp(1, "aaaaa");
        Emp emp2 = new Emp(2, "bbbbb");
        Emp emp8 = new Emp(8, "hhhhh");
        hash.add(emp1);
        hash.add(emp2);
        hash.add(emp8);
        hash.list();

        System.out.println("==========");
        System.out.println(hash.findEmp(77777));
    }
}
