package cn.com.bjjdsy.ksp;

public class Tester {
	private static final int PATHS = 30;

	public static void main(String[] args) {
		Stopwatch timer = new Stopwatch();

		// read the graph
		timer.start();
		Graph g = new Graph();
		g.readGraph();
		timer.stop();

		System.out.printf("Time to generate the graph: %.6f seconds\n", timer.time());

		// get all shortest paths
		timer.start();
		g.getPaths(PATHS);
		timer.stop();

		System.out.printf("Time it takes to get all the shortest paths: %.6f seconds\n", timer.time());

		// get all shortest paths
		timer.start();
		g.printPaths();

//		g.printPath(125, 423);
//		g.printPath(201, 211);
//		g.printPath(201, 209);
//		g.printPath(214, 443);
//		g.printPath(653, 201);
//		g.printPath(113, 208);
//		g.printPath(201, 457);
//		g.printPath(649, 124);
//		g.printPath(214, 9441);//line change???  
//		g.printPath(110, 9055);
		timer.stop();

		System.out.printf("Time it takes to print the paths: %.6f seconds\n", timer.time());

		System.exit(1);

	}

}
