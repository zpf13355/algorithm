package linked;

public class LinkedList implements List {
    public Node head;   // 指向第一个结点
    public Node last;   // 指向最后一个结点
    public int size;

    @Override
    // O(1)
    public boolean add(Integer e) {
        // 判断链表中没有结点，哪种判断都可以，等价的
        // if (size == 0)
        // if (head == null)
        // if (last == null)

        Node newNode = new Node(e);
        if (size == 0) {
            this.head = this.last = newNode;
        } else {
            this.last.next = newNode;
            newNode.prev = this.last;
            this.last = newNode;
        }
        this.size++;

        return true;
    }

    @Override
    // O(n)
    public void add(int index, Integer e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界: " + index);
        }

        if (index == size) {
            // 尾插
            add(e);
        } else if (index == 0) {
            // 头插
            Node newNode = new Node(e); // 把值装入结点中
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;

            size++;
        } else {
            // 其他情况
            // 找到 index - 1 所在的位置，进行结点的插入
            Node prev;
            if (index - 1 < size / 2) {
                prev = head;
                // 从 head 处出发，找到 index - 1 位置的结点
                // 从图中得出，一共要跳 index - 1 次
                for (int i = 0; i < index - 1; i++) {
                    prev = prev.next;
                }
            } else {
                // 从 last 处出发，找到 index - 1 位置的结点
                // 从图中得出，一共要跳 (size - 1) - (index - 1) 次
                prev = last;
                for (int i = 0; i < size - index; i++) {
                    prev = prev.prev;
                }
            }
            // 走到这里时，prev 指向 index - 1 位置的下标

            Node next = prev.next;
            Node newNode = new Node(e); // 把值装入结点中

            newNode.prev = prev;
            newNode.next = next;
            prev.next = newNode;
            next.prev = newNode;

            size++;
        }
    }

    @Override
    // O(n)
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界: " + index);
        }
        // 走到这里，size 一定是 > 0 的

        Integer v;
        if (index == 0) {
            v = head.element;
            this.head = this.head.next;
            this.head.prev = null;
            size--;
            if (size == 0) {
                last = null;
            }
        } else if (index == size - 1) {
            v = last.element;
            this.last = this.last.prev;
            this.last.next = null;
            size--;
            if (size == 0) {
                head = null;
            }
        } else {
            // 找到 index - 1 所在的位置，进行结点的插入
            Node prev;
            if (index - 1 < size / 2) {
                prev = head;
                // 从 head 处出发，找到 index - 1 位置的结点
                // 从图中得出，一共要跳 index - 1 次
                for (int i = 0; i < index - 1; i++) {
                    prev = prev.next;
                }
            } else {
                // 从 last 处出发，找到 index - 1 位置的结点
                // 从图中得出，一共要跳 (size - 1) - (index - 1) 次
                prev = last;
                for (int i = 0; i < size - index; i++) {
                    prev = prev.prev;
                }
            }

            Node toRemove = prev.next;
            v = toRemove.element;
            prev.next = toRemove.next;
            toRemove.next.prev = prev;
            size--;
        }

        return v;
    }

    /*@Override
    // O(n)
    public boolean remove(Integer e) {
        Node prev = null;
        for (Node cur = head; cur != null; prev = cur, cur = cur.next) {
            if (cur.element.equals(e)) {
                if (prev == null) {
                    remove(0);
                    return true;
                } else {
                    prev.next.next.prev = prev;
                    prev.next = prev.next.next;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    // O(n)
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界: " + index);
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    @Override
    // O(n)
    public Integer set(int index, Integer e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界: " + index);
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        Integer v = cur.element;
        cur.element = e;
        return v;
    }

    @Override
    // O(1)
    public int size() {
        return size;
    }

    @Override
    // O(1)
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    @Override
    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    // O(n)
    public boolean contains(Integer e) {
        return indexOf(e) != -1;
    }

    @Override
    // O(n)
    public int indexOf(Integer e) {
        int i = 0;
        for (Node cur = head; cur != null; cur = cur.next, i++) {
            if (cur.element.equals(e)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    // O(n)
    public int lastIndexOf(Integer e) {
        int i = size - 1;
        for (Node cur = last; cur != null; cur = cur.prev, i--) {
            if (cur.element.equals(e)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Iterator iterator() {
        //return new LinkedListIterator(this);
        return null;
    }
*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.element);
            if (cur != last) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
