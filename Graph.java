/**
 *
 * @todo getters and setters
 * @todo test validation
 */

import java.util.ArrayList;
import java.util.List;

public class Graph
{
  private final Node[] nodes;

  public Graph(String[] representation) // name, name, dist, name, dist, name, name, dist...
  {
    List<Node> nodeList = new ArrayList<Node>(); // mutable list holding nodes so far 

    String currentNodeString = null; // name of the current node
    List<Edge> edgeList = new ArrayList<Edge>(); // list of all the edges for the current node so far

    for(int index = 0; index < representation.length; /* nothing */)
    {
      String symbol1, symbol2;

      symbol1 = representation[index]; // always a String
      symbol2 = representation[index + 1]; // may be String or int

      try
      {
        int symbol2Int = Integer.parseInt(symbol2);

        // if here (String, int) => edge
        Edge currentEdge = new Edge(symbol1, symbol2Int);

        edgeList.add(currentEdge);

        index += 2;

      }
      catch(Exception e) // if here (String, String) => new node
      {
        if(edgeList.size() == 0) // first node
        {
          currentNodeString = symbol1;
        }
        else // we are starting another node
        {
          Node finishedNode = new Node(currentNodeString, edgeList.toArray(new Edge[edgeList.size()]));
          nodeList.add(finishedNode);

          edgeList = new ArrayList<Edge>(); // empty the edge list
          currentNodeString = symbol1;
        }
        index++;
      }
    }
    nodeList.add(new Node(currentNodeString, edgeList.toArray(new Edge[edgeList.size()])));
    nodes = nodeList.toArray(new Node[nodeList.size()]);
  }

  public Node[] getNodes() {return nodes;}

  public String toString()
  {
    StringBuilder representation = new StringBuilder();
    for (int index = 0; index < nodes.length; index++)
    {
      if (index == 0)
        representation.append("    " + nodes[index]);
      else
        representation.append("\n    " + nodes[index]);
    }
    return "------------------------\nGraph (size: " + nodes.length + ")\n------------------------\n  Nodes:\n" + representation;
  }

  public static boolean validateGraph(Graph graphToValidate, boolean strictValidation)
  {
    for (Node node : graphToValidate.getNodes())
    {
      if(!validateNode(node, graphToValidate, strictValidation))
        return false;  
    }
    return true;
  }

  public static boolean validateNode(Node nodeToValidate, Graph graphToValidate, boolean strictValidation)
  {
    for (Edge edge : nodeToValidate.getEdges())
    {
      if(!validateEdge(edge, nodeToValidate, graphToValidate, strictValidation))
        return false;
    }
    return true;
  }

  public static boolean validateEdge(Edge edgeToValidate, Node nodeToValidate, Graph graphToValidate, boolean strictValidation)
  {
    String start = nodeToValidate.getName();
    String end = edgeToValidate.getConnectedNodeName();
    int distance = edgeToValidate.getDistance();

    for (Node node : graphToValidate.getNodes()) // find the end Node in the graph
    {
      if (node.getName().equals(end))
      {
        for (Edge edge: node.getEdges())  // find the corresponding edge
        {
          if (edge.getConnectedNodeName().equals(start))
          {
            if(strictValidation)
            {
              if(distance == edge.getDistance())
                return true; // corresponding edge and distance
              else
                return false; // coresponding edge different distance
            }
            else
             return true; // corresponding edge
          }
        }
      return false; // matching node doesn't have corresponding edge
      }
    }
    return false; // no node matches the end name
  }
}