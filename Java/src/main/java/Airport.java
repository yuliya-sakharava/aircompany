import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import Planes.experimentalPlane;
import models.MilitaryType;

import java.util.*;

public class Airport {
  private final List<? extends Plane> planes;

  public List<PassengerPlane> getPasPl() {
    List<PassengerPlane> x = new ArrayList<>();
    for (Plane p : this.planes) {
      if (p instanceof PassengerPlane) {
        x.add((PassengerPlane) p);
      }
    }
    return x;
  }

  public List<MilitaryPlane> getMilitaryPlanes() {
    List<MilitaryPlane> militaryPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof MilitaryPlane) {
        militaryPlanes.add((MilitaryPlane) plane);
      }
    }
    return militaryPlanes;
  }

  public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
    List<PassengerPlane> passengerPlanes = getPasPl();
    PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
    for (PassengerPlane passengerPlane : passengerPlanes) {
      if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
        planeWithMaxCapacity = passengerPlane;
      }
    }
    return planeWithMaxCapacity;
  }

  public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    for (MilitaryPlane plane : militaryPlanes) {
      if (plane.getType() == MilitaryType.TRANSPORT) {
        transportMilitaryPlanes.add(plane);
      }
    }
    return transportMilitaryPlanes;
  }

  public List<MilitaryPlane> getBomberMilitaryPlanes() {
    List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    for (MilitaryPlane plane : militaryPlanes) {
      if (plane.getType() == MilitaryType.BOMBER) {
        bomberMilitaryPlanes.add(plane);
      }
    }
    return bomberMilitaryPlanes;
  }

  public List<experimentalPlane> getExperimentalPlanes() {
    List<experimentalPlane> experimentalPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof experimentalPlane) {
        experimentalPlanes.add((experimentalPlane) plane);
      }
    }
    return experimentalPlanes;
  }

  public Airport sortByMaxDistance() {
    planes.sort((Comparator<Plane>) (o1, o2) -> o1.Get_Max_Flight_Distance() - o2.Get_Max_Flight_Distance());
    return this;
  }

  public Airport sortByMaxSpeed() {
    planes.sort((Comparator<Plane>) (o1, o2) -> o1.getMS() - o2.getMS());
    return this;
  }

  public void sortByMaxLoadCapacity() {
    planes.sort((Comparator<Plane>) (o1, o2) -> o1.getMinLoadCapacity() - o2.getMinLoadCapacity());
  }

  public List<? extends Plane> getPlanes() {
    return planes;
  }

  private void print(Collection<? extends Plane> collection) {
    for (Plane plane : collection) {
      System.out.println(plane);
    }
  }

  @Override
  public String toString() {
    return "Airport{" + "Planes=" + planes.toString() + '}';
  }

  public Airport(List<? extends Plane> planes) {
    this.planes = planes;
  }
}
