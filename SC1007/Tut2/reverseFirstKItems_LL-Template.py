class ListNode:
    def __init__(self, item):
        self.item = item
        self.next = None

class LinkedList:
    def __init__(self):
        self.size = 0
        self.head = None
        self.tail = None

    def find_node(self, index):
        if index < 0 or index >= self.size:
            return None
        temp = self.head
        for _ in range(index):
            temp = temp.next
        return temp

    def insert_node(self, index, value):
        if index < 0 or index > self.size:
            return -1
        new_node = ListNode(value)
        if index == 0:
            new_node.next = self.head
            self.head = new_node
            if self.size == 0:
                self.tail = new_node
        elif index == self.size:
            self.tail.next = new_node
            self.tail = new_node
        else:
            prev = self.find_node(index - 1)
            new_node.next = prev.next
            prev.next = new_node
        self.size += 1
        return 0

    def remove_node(self, index):
        if index < 0 or index >= self.size:
            return -1
        if index == 0:
            self.head = self.head.next
            if self.size == 1:
                self.tail = None
        else:
            prev = self.find_node(index - 1)
            prev.next = prev.next.next
            if index == self.size - 1:
                self.tail = prev
        self.size -= 1
        return 0
    
    def printList(self):
        cur = self.head
        if cur is None:
            print("Empty")
            return
        while cur is not None:
            print(cur.item, end=" ")
            cur = cur.next
        print("\n")

class Stack:
    def __init__(self):
        self.ll = LinkedList()

    def push(self, item):
        self.ll.insert_node(0, item)

    def pop(self):
        if self.isEmpty():
            return None
        item = self.ll.head.item
        self.ll.remove_node(0)
        return item

    def peek(self):
        if self.isEmpty():
            return None
        return self.ll.head.item

    def isEmpty(self):
        return self.ll.size == 0
    
    def printStack(self):
        self.ll.printList()

class Queue:
    def __init__(self):
        self.ll = LinkedList()

    def enqueue(self, item):
        self.ll.insert_node(self.ll.size, item)

    def dequeue(self):
        if self.isEmpty():
            return None
        item = self.ll.head.item
        self.ll.remove_node(0)
        return item

    def isEmpty(self):
        return self.ll.size == 0
    
    def printQueue(self):
        self.ll.printList()

def reverseFirstKItems(queue, k):
    temp_stack = Stack()
    temp_queue = Queue()

    for i in range(k):
        if queue.isEmpty():
            raise IndexError
        temp_stack.push(queue.dequeue())
    
    while not queue.isEmpty():
        temp_queue.enqueue(queue.dequeue())

    while not temp_stack.isEmpty():
        queue.enqueue(temp_stack.pop())

    while not temp_queue.isEmpty():
        queue.enqueue(temp_queue.dequeue())


if __name__ == "__main__":
    queue = Queue()
    while True:
        print("1: Insert an integer to the queue:")
        print("2: Reverse the queue:")
        print("0: Quit:")

        choice = int(input("Please input your choice (1/2/0): "))

        if choice == 1:
            value = int(input("Input an integer that you want to add to the queue: "))
            queue.enqueue(value)
            print("The resulting queue is:")
            queue.printQueue()
        elif choice == 2:
            k = int(input("Enter an integer to reverse the queue until that number: "))
            print("The resulting queue after reversing its elements is: ")
            reverseFirstKItems(queue, k)
            queue.printQueue()
        elif choice == 0:
            break
        else:
            print("Choice unknown;")