package cn.com.bjjdsy.ksp;

import java.util.*;

/**
 * Station data for an individual line at each station
 * 
 * Larger stations are actually made up of multiple Stations, since each line
 * crossing through has a separate stop
 *
 */
public class Station implements Comparable<Station> {
	// the ID and line
	private int ID;
	private Track line;

	// the name of the station
	private String name;

	// the neighbors and the lines they correspond to
	private TreeSet<Station> neighbors;
	private TreeMap<Station, Line> lines;
	
	private int tsCode;

	public TreeMap<Station, Line> getLines() {
		return lines;
	}

	/**
	 * Default constructor
	 */
	public Station() {
		this(-1, null, null);
	}

	/**
	 * Constructor for a station
	 * 
	 * @param ID   ID for the station
	 * @param line Line that the station is connected to
	 * @param name Name of the station
	 */
	public Station(int ID, Track line, String name) {
		this.setID(ID);
		this.setLine(line);
		this.setName(name);

		neighbors = new TreeSet<Station>();
		lines = new TreeMap<Station, Line>();
	}

	/**
	 * Checks if a station is connected
	 * 
	 * pre: other != null
	 * 
	 * @param other Other station
	 * @return A boolean that indicates if the station is connected
	 */
	public boolean isConnected(Station other) {
		// checks precon
		if (other == null)
			throw new IllegalArgumentException();

		return neighbors.contains(other);
	}

	/**
	 * Adds a connection to this station
	 * 
	 * pre: add != null, add has as one of its endpoints the correct station
	 * 
	 * @param add The connection to add
	 */
	public void addConnection(Line add) {
		// check preconditions
		if (add == null)
			throw new IllegalArgumentException();

		if (add.getStart() == this) {
			// if the starting point of the line is this
			neighbors.add(add.getEnd());
			lines.put(add.getEnd(), add);
		} else if (add.getEnd() == this) {
			return;

			// if the ending point of the line is this
//			neighbors.add(add.getStart());
//			lines.put(add.getStart(), add);
		} else
			throw new IllegalArgumentException();
//		System.out.println(add.getStart().getID() + " addConnection:" + neighbors.size() + " " + add.getEnd().getID());
	}

	/**
	 * @return The neighbors to this station in a TreeSet format
	 */
	public TreeSet<Station> getNeighbors() {
		return neighbors;
	}

	/**
	 * Gets the connecting Line with another station
	 * 
	 * pre: other != null
	 * 
	 * @param other The station that is connected
	 * @return The Line that connects the two, null if not connected
	 */
	public Line getConnection(Station other) {
		// checks preconditions
		if (other == null)
			throw new IllegalArgumentException();

		// checks to see if it is connected
		if (!isConnected(other))
			return null;

		// return the line
		return lines.get(other);
	}

	/**
	 * @return the ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param ID the ID to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the line
	 */
	public Track getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(Track line) {
		this.line = line;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		// if this is not a Station return false
		if (!(o instanceof Station))
			return false;

		Station other = (Station) o;

		return (other.ID == ID) && (other.line.equals(this.line));
	}

	@Override
	public int compareTo(Station s) {
		return ID - s.ID;
	}

	public int getTsCode() {
		return tsCode;
	}

	public void setTsCode(int tsCode) {
		this.tsCode = tsCode;
	}
}
