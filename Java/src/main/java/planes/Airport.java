package planes;

import models.MilitaryType;

import java.util.*;

public class Airport {
  private final List<? extends Plane> planes;

  public List<PassengerPlane> getPassengerPlane() {
    List<PassengerPlane> planeList = new ArrayList<>();
    for (Plane plane : this.planes) {
      if (plane instanceof PassengerPlane) {
        planeList.add((PassengerPlane) plane);
      }
    }
    return planeList;
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
    List<PassengerPlane> passengerPlanes = getPassengerPlane();
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

  public List<ExperimentalPlane> getExperimentalPlanes() {
    List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof ExperimentalPlane) {
        experimentalPlanes.add((ExperimentalPlane) plane);
      }
    }
    return experimentalPlanes;
  }

  public Airport sortByDistance() {
    planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    return this;
  }

  public Airport sortBySpeed() {
    planes.sort(Comparator.comparingInt(Plane::getMS));
    return this;
  }

  public void sortByLoadCapacity() {
    planes.sort(Comparator.comparingInt(Plane::getMinLoadCapacity));
  }

  public List<? extends Plane> getPlanes() {
    return planes;
  }

  @Override
  public String toString() {
    return "planes.Airport{" + "Planes=" + planes.toString() + '}';
  }

  public Airport(List<? extends Plane> planes) {
    this.planes = planes;
  }
}
