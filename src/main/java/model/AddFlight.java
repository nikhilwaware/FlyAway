package model;

public class AddFlight {

	private int flightId;
	private String flightName;
	private String source;
	private String destination;
	private int economy;
	private int business;
	private int premium;
	private String days;
	
	public AddFlight() {
		
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getEconomy() {
		return economy;
	}

	public void setEconomy(int economy) {
		this.economy = economy;
	}

	public int getBusiness() {
		return business;
	}

	public void setBusiness(int business) {
		this.business = business;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public AddFlight(String flightName, String source, String destination, int economy, int business, int premium,
			String days) {
		super();
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.economy = economy;
		this.business = business;
		this.premium = premium;
		this.days = days;
	}

	
	public AddFlight(int flightId, String flightName, String source, String destination, int economy, int business,
			int premium, String days) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.economy = economy;
		this.business = business;
		this.premium = premium;
		this.days = days;
	}

	@Override
	public String toString() {
		return "AddFlight [flightId=" + flightId + ", flightName=" + flightName + ", source=" + source
				+ ", destination=" + destination + ", economy=" + economy + ", business=" + business + ", premium="
				+ premium + ", days=" + days + "]";
	}
	
	
}
