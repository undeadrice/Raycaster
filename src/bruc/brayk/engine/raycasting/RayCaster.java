package bruc.brayk.engine.raycasting;

import java.util.ArrayList;
import java.util.List;

import bruc.brayk.entity.Camera;
import bruc.brayk.entity.WallType;
import bruc.brayk.map.Map;
import bruc.brayk.math.Helper;
import bruc.brayk.math.Vector;

public class RayCaster {

	private final double FOV = 60;

	private final int SLICES = 1440;

	private final double dAngle = FOV / SLICES;

	private Camera camera;
	private Map map;
	private List<Ray> rays = new ArrayList<>();

	public RayCaster(Camera camera, Map map) {
		this.camera = camera;
		this.map = map;
		generateRays();
	}

	public void generateRays() {
		for (int i = 0; i < SLICES; i++) {
			Ray ray = new Ray();
			ray.setColumn(i);
			this.rays.add(ray);
		}

	}

	public List<Vector> generateNodes(double dAngle) {
		List<Vector> nodes = new ArrayList<>();
		List<Vector> hNodes = generateHorizontalNodes(dAngle);
		List<Vector> vNodes = generateVerticalNodes(dAngle);
		// add camera as node
		nodes.add(new Vector(camera.getVector().getX(), camera.getVector().getY()));

		double hl = Double.MAX_VALUE;
		double vl = Double.MAX_VALUE;

		if (hNodes.size() != 0)
			hl = Helper.pythagoreanC(nodes.get(0), hNodes.get(hNodes.size() - 1));
		if (vNodes.size() != 0)
			vl = Helper.pythagoreanC(nodes.get(0), vNodes.get(vNodes.size() - 1));

		nodes.addAll(hl < vl ? hNodes : vNodes);

		return nodes;
	}

	private List<Vector> generateVerticalNodes(double dAngle) {
		List<Vector> vNodes = new ArrayList<>();
		Vector first = firstVerticalNode(dAngle);
		if (first == null) {
			return vNodes;
		}
		vNodes.add(first);
		if (map.tileWalled(first)) {
			return vNodes;
		} else {
			for (int i = 0; i < 5; i++) {
				if (!map.tileWalled(vNodes.get(i))) {
					vNodes.add(nextVerticalNode(vNodes.get(i), dAngle));
					continue;
				}
				break;
			}
		}
		return vNodes;
	}

	private List<Vector> generateHorizontalNodes(double dAngle) {
		List<Vector> hNodes = new ArrayList<>();
		Vector first = firstHorizontalNode(dAngle);
		if (first == null) {
			return hNodes;
		}
		hNodes.add(first);
		if (map.tileWalled(first)) {
			return hNodes;
		} else {
			for (int i = 0; i < 5; i++) {
				if (!map.tileWalled(hNodes.get(i))) {
					hNodes.add(nextHorizontalNode(hNodes.get(i), dAngle));
					continue;
				}
				break;
			}
		}
		return hNodes;
	}

	// pion
	private Vector firstVerticalNode(double dAngle) {
		double rayAngle = Helper.calcAngle(camera.getAngle() + dAngle);
		double x, y;

		// facing right
		if (rayAngle > 0.01 && rayAngle < 180) {
			x = camera.getVector().getX() + (64 - camera.getVector().getGridX()) + 1;
			double dx = x - camera.getVector().getX();
			double alpha = Helper.calcAngle(90 - rayAngle);
			double dy = Math.tan(Math.toRadians(alpha)) * dx;
			y = camera.getVector().getY() - dy;
			return new Vector(x, y);
		}

		// facing left
		else if (rayAngle > 180 && rayAngle < 360) {
			x = camera.getVector().getX() - camera.getVector().getGridX() - 1;
			double dx = x - camera.getVector().getX();
			double alpha = Helper.calcAngle(270 - rayAngle);
			double dy = Math.tan(Math.toRadians(alpha)) * dx;
			y = camera.getVector().getY() - dy;
			return new Vector(x, y);
		}

		return null;
	}

	private Vector nextVerticalNode(Vector last, double dAngle) {
		double rayAngle = Helper.calcAngle(camera.getAngle() + dAngle);
		double x, y;

		// facing right
		if (rayAngle > 0.01 && rayAngle < 180) {
			x = last.getX() + 64;
			double dx = 64;
			double alpha = Helper.calcAngle(90 - rayAngle);
			double dy = Math.tan(Math.toRadians(alpha)) * dx;
			y = last.getY() - dy;
			return new Vector(x, y);
		}

		// facing left
		else if (rayAngle > 180 && rayAngle < 360) {
			x = last.getX() - 64;
			double dx = -64;
			double alpha = Helper.calcAngle(270 - rayAngle);
			double dy = Math.tan(Math.toRadians(alpha)) * dx;
			y = last.getY() - dy;
			return new Vector(x, y);
		}

		return null;
	}

	// poziom
	private Vector firstHorizontalNode(double dAngle) {
		double rayAngle = Helper.calcAngle(camera.getAngle() + dAngle);
		double x, y;
		// facing up
		if (rayAngle > 270 || rayAngle < 90) {
			y = camera.getVector().getY() - camera.getVector().getGridY() - 1;
			double dy = camera.getVector().getY() - y;
			double alpha = Helper.calcAngle(90 + rayAngle);
			double dx = dy / Math.tan(Math.toRadians(alpha));
			x = camera.getVector().getX() - dx;

			return new Vector(x, y);
		}
		// facing down
		else if (rayAngle > 90 && rayAngle < 270) {
			y = camera.getVector().getY() + (64 - camera.getVector().getGridY()) + 1;
			double dy = camera.getVector().getY() - y;
			double alpha = Helper.calcAngle(90 + rayAngle);
			double dx = dy / Math.tan(Math.toRadians(alpha));
			x = camera.getVector().getX() - dx;

			return new Vector(x, y);
		}

		return null;
	}

	private Vector nextHorizontalNode(Vector last, double dAngle) {
		double rayAngle = Helper.calcAngle(camera.getAngle() + dAngle);
		double x, y;
		// facing up
		if (rayAngle > 270 || rayAngle < 90) {
			y = last.getY() - 64;
			double dy = -64;
			double alpha = Helper.calcAngle(90 + rayAngle);
			double dx = dy / Math.tan(Math.toRadians(alpha));
			x = last.getX() + dx;

			return new Vector(x, y);
		}
		// facing down
		else if (rayAngle > 90 && rayAngle < 270) {
			y = last.getY() + 64;
			double dy = 64;
			double alpha = Helper.calcAngle(90 + rayAngle);
			double dx = dy / Math.tan(Math.toRadians(alpha));
			x = last.getX() + dx;

			return new Vector(x, y);
		}

		return null;

	}

	// gen all

	public void updateAndCheckRay() {
		double dAngle = FOV / SLICES;
		double curAngle = -SLICES / 2 * dAngle;
		for (Ray ray : rays) {
			ray.setNodes(generateNodes(curAngle));
			Vector v = ray.getNodes().get(ray.getNodes().size()-1);
			ray.setCollidingWith(map.getWallType(v)) ;
			ray.setDeltaAngle(curAngle);

			curAngle += dAngle;

		}
	}

	public List<Ray> getRays() {
		return rays;
	}

	public void setRays(List<Ray> rays) {
		this.rays = rays;
	}

}
