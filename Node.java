/**
 *
 * @todo getters and setters
 */
public class Node
{
  private final String name;
  private final Edge[] edges;

  public Node(String requiredName, Edge[] requiredEdges)
  {
    name = requiredName;
    edges = requiredEdges;
  }

  public String getName() {return name;}

  public Edge[] getEdges() {return edges;}

  public String toString()
  {
    StringBuilder representation = new StringBuilder();
    for (int index = 0; index < edges.length; index++)
    {
      if (index == 0)
        representation.append("        " + edges[index]);
      else
        representation.append("\n        " + edges[index]);
    }
    return "(" + name + ")\n      Edges:\n" + representation;
  }
}