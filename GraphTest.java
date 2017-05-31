public class GraphTest
{
  public static void main(String[] args)
  {
    Graph graph;

    if (args.length == 0)
    {
      System.out.println("Default test:");
      String[] representation = {"A", "B", "3", "C", "2", "B", "A", "3", "C", "1", "C", "A", "2", "B", "1"};
      graph = new Graph(representation);  
      System.out.println(graph);
    }
    else
    {
      String[] representation = args;
      graph = new Graph(representation);  
      System.out.println(graph);
    }
    if (Graph.validateGraph(graph, true))
      System.out.println("Graph is valid (strict)");
    else if(Graph.validateGraph(graph, false))
      System.out.println("Graph is valid (not strict)");
    else
      System.out.println("Graph is invalid!");
  }
}