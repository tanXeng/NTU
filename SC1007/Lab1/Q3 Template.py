class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def insert(self, data, index):
        new_node = Node(data)
        if self.head is None or index == 0:
            new_node.next = self.head
            self.head = new_node
            return True

        current = self.head
        count = 0

        while current and count < index - 1:
            current = current.next
            count += 1

        if not current:
            print("Index out of range")
            return False

        new_node.next = current.next
        current.next = new_node
        return True

    def printList(self):
        current = self.head
        while current:
            print(current.data, end=" ")
            current = current.next
        print()

    def deleteList(self):
        current = self.head
        while current:
            temp = current.next
            current.next = None
            current = temp
        self.head = None

def split(ll):
    cur = ll.head
    odd_linked_list = LinkedList()
    even_linked_list = LinkedList()
    odd_linked_list_tail = 0
    even_linked_list_tail = 0
    index = 0

    while cur != None:
        if index%2 == 1: # if odd move to the back of the odd list 
            odd_linked_list.insert(cur.data, odd_linked_list_tail)
            odd_linked_list_tail += 1
            cur = cur.next
        else: # if even move to the back of the even list 
            even_linked_list.insert(cur.data, even_linked_list_tail)
            even_linked_list_tail += 1
            cur = cur.next
        index += 1
    return even_linked_list, odd_linked_list


if __name__ == "__main__":
    linked_list = LinkedList()
    index = 0

    print("Enter one number per line (press Enter after each number).")
    print("Enter any non-digit character to finish input:")
    try:
        while True:
            item = int(input())
            if linked_list.insert(item, index):
                print(f"Successfully inserted {item} at index {index}")
                index += 1
            else:
                print(f"Failed to insert {item}")
    except ValueError:
        pass

    print("\nBefore split() is called:")
    print("Current list:", end=" ")
    linked_list.printList()

    even_list, odd_list = split(linked_list)

    print("\nAfter split() was called:")
    print("Current list:", end=" ")
    linked_list.printList()

    print("Even list:", end=" ")
    even_list.printList()

    print("Odd list:", end=" ")
    odd_list.printList()

    linked_list.deleteList()
    even_list.deleteList()
    odd_list.deleteList()