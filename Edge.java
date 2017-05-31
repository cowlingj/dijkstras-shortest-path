/**
 *
 * @todo getters and setters
 */
public class Edge
{
  private final String connectedNodeName;
  private final int distance;

  public Edge(String requiredConnectedNodeName, int requiredDistance)
  {
    connectedNodeName = requiredConnectedNodeName;
    distance = requiredDistance;
  }

  public String getConnectedNodeName() {return connectedNodeName;}

  public int getDistance() {return distance;}

  public String toString()
  {
    return "-->(" + connectedNodeName + ", " + distance + ")";
  }
}