package cn.com.bjjdsy.ksp;

import java.util.*;

public class Path implements Comparable<Path> {
	private ArrayList<Station> stations;
	private ArrayList<Line> lines;
	private int dist;

	public void setDist(int dist) {
		this.dist = dist;
	}

	private double impedance;

	public void setImpedance(double impedance) {
		this.impedance = impedance;
	}

	public double getImpedance() {
		return impedance;
	}

	public void addImpedance(double impedance) {
		this.impedance += impedance;
	}

	/**
	 * Default constructor
	 */
	public Path() {
		dist = 0;
		impedance = 0;
		stations = new ArrayList<Station>();
		lines = new ArrayList<Line>();
	}

	/**
	 * Constructor copying from a path
	 * 
	 * @param Path to be copied from
	 */
	public Path(Path p) {
		dist = p.dist;
		impedance = p.impedance;
		stations = new ArrayList<Station>();
		lines = new ArrayList<Line>();
		for (Station s : p.stations)
			stations.add(s);
		for (Line l : p.lines)
			lines.add(l);
	}

	/**
	 * Add the source station
	 * 
	 * @param source The source station
	 */
	public void addStation(Station source) {
		if (source == null)
			throw new IllegalArgumentException();

		// add the station
		stations.add(source);
	}

	/**
	 * Add a station
	 * 
	 * @param add  Station to be added
	 * @param line Line that connects this station to the previous station
	 */
	public void addStation(Station add, Line line) {
		if (add == null)
			throw new IllegalArgumentException();

//		if (stations.contains(add))
//		{
//			// stations.add(add);
//			// lines.add(line);
//			return true;
//		}
//
		// add the station
		stations.add(add);
		lines.add(line);
//		return false;
	}

	/**
	 * 
	 * @return The stations in the path
	 */
	public ArrayList<Station> getStations() {
		return stations;
	}

	/**
	 * 
	 * @return The lines in the path
	 */
	public ArrayList<Line> getLines() {
		return lines;
	}

	/**
	 * Get the end station
	 * 
	 * pre: there is at least one station
	 * 
	 * @return The end station
	 */
	public Station getEnd() {
		if (stations.size() == 0)
			throw new IllegalArgumentException();

		return stations.get(stations.size() - 1);
	}

	public Station getPrev(Station s) {
		int idx = stations.indexOf(s);
		return stations.get(idx - 1);
	}

	/**
	 * Add more distance
	 * 
	 * @param add distance to be added
	 */
	public void addDist(int add) {
		dist += add;
	}

	/**
	 * 
	 * @return Distance of the path
	 */
	public int getDist() {
		return dist;
	}

	@Override
	public int compareTo(Path other) {
		// compare the dist
//		if (other.dist != dist)
//			return dist - other.dist;

		// compare the impedance
		if (other.impedance != impedance) {
			return (int) (impedance - other.impedance);
		}

		// compare the number of stations
		return stations.size() - other.stations.size();
	}

	@Override
	public boolean equals(Object o) {
		// check the instance of the other object and cast
		if (!(o instanceof Path))
			return false;

		Path other = (Path) o;

		// compare the dist
		if (other.dist != dist)
			return false;

		// compare the number of stations
		if (other.stations.size() != stations.size())
			return false;

		// compare the stations themselves
		for (int i = 0; i < stations.size(); ++i)
			if (!other.stations.get(i).equals(stations.get(i)))
				return false;

		return true;
	}
}
