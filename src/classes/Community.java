package classes;

public class Community implements Comparable<Community>{
	
	public String name;
	public int pop;
	
	public Community(String name, String population){
		this.name = name;
		this.pop = Integer.parseInt(population);
	}
	
	public String getLine(){
		return name + "," + pop + "\n";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPop() {
		return pop;
	}
	public void setPop(int pop) {
		this.pop = pop;
	}

	@Override
	public int compareTo(Community c) {
		return c.pop - pop;
	}
	
	
}
