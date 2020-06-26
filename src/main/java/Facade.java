
public class Facade {

  public class Node {

    public String value;
    public Node right;
    public Node left;

    public void setval(String val) {
      value = val;
    }

    public Node(String val) {
      value = val;
    }

  }//End node class

  public class Tree {

    public Node root;

    public Tree(String val) {
      root = new Node(val);
      split(root);
    }

    public void split(Node node) {

      int indMin = node.value.lastIndexOf('-');
      int indAdd = node.value.lastIndexOf('+');
      int indMul = node.value.lastIndexOf('*');
      int indDiv = node.value.lastIndexOf('/');
      int ind = -1;

      if (indMin != -1 || indAdd != -1) {
        ind = Math.max(indMin, indAdd);
      } else if (indMul != -1 || indDiv != -1) {
        ind = Math.max(indMul, indDiv);
      } else {
        return;
      }

      String left = node.value.substring(0, ind);
      String right = node.value.substring(ind + 1);

      node.value = String.valueOf(node.value.charAt(ind));

      node.left = new Node(left);
      node.right = new Node(right);

      split(node.left);
      split(node.right);
    }

  }//End tree class


  private Tree eq;

  public float eval() {
    if (eq.root != null) {
      return Float.parseFloat(eval(eq.root));
    }
    return 0.0f;
  }

  public Facade(String equation) {
    eq = new Tree(equation);
  }


  private String eval(Node node) {

    String left = "";
    String right = "";
    String result = "";

    if (node.right != null) {
      right = eval(node.right);
    }
    if (node.left != null) {
      left = eval(node.left);
    }

    if (node.left != null && node.right != null) {

      System.out.print(node.left.value);
      System.out.print(node.value);
      System.out.print(node.right.value);
      System.out.print(" = ");

      if (node.value.equals("+")) {
        result = Float.toString(Float.parseFloat(left) + Float.parseFloat(right));
      } else if (node.value.equals("-")) {
        result = Float.toString(Float.parseFloat(left) - Float.parseFloat(right));
      } else if (node.value.equals("/")) {
        result = Float.toString(Float.parseFloat(left) / Float.parseFloat(right));
      } else if (node.value.equals("*")) {
        result = Float.toString(Float.parseFloat(left) * Float.parseFloat(right));
      }
      System.out.print(result);
      System.out.print("\n");
      return result;

    } else {
      return node.value;
    }

  }

  float calculate() {
    if (eq.root.value.length() < 10) {
      return Float.parseFloat(eq.root.value);
    }
    else {
      return Float.parseFloat(eq.root.value.substring(10));
    }
  }
}

