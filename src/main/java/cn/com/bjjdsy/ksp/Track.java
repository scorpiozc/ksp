package cn.com.bjjdsy.ksp;

/**
 * Used to store the basic information about an entire line
 *
 */
public class Track implements Comparable<Track>
{
	// ID and name of the track
	private int ID;
	private String name;
	
	/**
	 * Constructor for the Track
	 */
	public Track()
	{
		setID(0);
		setName("");
	}
	
	/**
	 * Constructor for the Track, given inputs
	 * 
	 * @param _ID	ID of the track
	 * @param _name	Name of the track
	 */
	public Track(int _ID, String _name)
	{
		setID(_ID);
		setName(_name);
	}

	/**
	 * Gets the ID of the track
	 * 
	 * @return The ID of the track
	 */
	public int getID()
	{
		return ID;
	}

	/**
	 * Sets the ID of the track
	 * 
	 * @param ID	new ID of the track
	 */
	public void setID(int ID)
	{
		this.ID = ID;
	}

	/**
	 * Gets the name of the track
	 * 
	 * @return	name of the track
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the track
	 * 
	 * @param name	new name of the track
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int compareTo(Track t)
	{
		return ID - t.ID;
	}
	
	@Override
	public boolean equals(Object o)
	{
		// if this is not a Station return false
		if (!(o instanceof Track))
			return false;
		
		// cast it to a Line
		Track other = (Track) o;
		
		// compare the IDs
		return other.ID == this.ID;
	}
}
