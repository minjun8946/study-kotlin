class LinkedList1<T> {
    private var headNode: Node<T>? = null

    private fun findItemByPosition(position: Int): Node<T>? {
        var currentNode = headNode
        repeat(position) {
            currentNode = currentNode?.next
        }
        return currentNode
    }

    private var size = 0
    private var lastNode: Node<T>? = null

    fun linkNodeAtLast(item: T){
        val newNode = Node(item, null)
        lastNode?.next = newNode
        lastNode = newNode
        size++

        if(headNode == null){
            headNode = newNode
        }
    }

    fun linkNodeAtHead(item: T){
        val newNode = Node(item, headNode)
        headNode = newNode
        size++

        if(lastNode == null){
            lastNode = newNode
        }
    }

    fun linkNodeAtPosition(item: T, position: Int){
        if(position > size){
            println("error")
        }
        val beforeNode = findItemByPosition(position)
        val newNode = Node(item, beforeNode?.next)
        beforeNode?.next = newNode
    }


}


data class Node<T>(
    var item: T?,
    var next: Node<T>?
)

