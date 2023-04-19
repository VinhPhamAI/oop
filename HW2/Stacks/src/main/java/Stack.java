public class Stack <Item>{

    private class Node
    {
        private Item data;
        private Node nextNode;
        public Node(Item data)
        {
            this.data = data;
            this.nextNode = null;
        }
    }
    private Node top;
    public Stack()
    {
        top = null;
    }
    public void push(Item data)
    {
        Node new_node = new Node (data);
        new_node.nextNode = top;
        top = new_node;
    }
    public boolean isEmpty()
    {
        if(top == null) return true;
        return false;
    }
    public Item pop()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is empty");
        }
        Item dataTop = top.data;
        top = top.nextNode;
        return dataTop;
    }

}
