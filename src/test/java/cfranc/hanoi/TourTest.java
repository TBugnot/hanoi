package cfranc.hanoi;

import static org.junit.Assert.*;

import org.junit.Test;

public class TourTest {

	@Test
	public void emptyTower_addDisk_oneDiskTower() {//Cas 1
		Tour tower = new Tour(3);
		Disque disk = new Disque(4);
		//tests
		boolean b = tower.empiler(disk);
		assertEquals(true, b);
		assertEquals(1, tower.taille());
		assertEquals(4, tower.diam());
	}
	
	@Test
	public void oneDiskTower_addDiskSmallerDiameter_twoDiskTower() {//Cas 2
		Tour tower = new Tour(3);
		Disque disk1 = new Disque(5);
		Disque disk2 = new Disque(4);
		tower.empiler(disk1);
		//tests
		boolean b = tower.empiler(disk2);
		assertEquals(true, b);
		assertEquals(2, tower.taille());
		assertEquals(4, tower.diam());
	}
	
	@Test
	public void fullTower_addDiskSmallerDiameter_fullTower() {//Cas 3a
		Tour tower = new Tour(3);
		Disque disk1 = new Disque(15);
		Disque disk2 = new Disque(14);
		Disque disk3 = new Disque(13);
		Disque disk4 = new Disque(5);
		tower.empiler(disk1);
		tower.empiler(disk2);
		tower.empiler(disk3);
		//tests
		boolean b = tower.empiler(disk4);
		assertEquals(false, b);
		assertEquals(3, tower.taille());
		assertEquals(13, tower.diam());
	}
	
	@Test
	public void oneDiskTower_addDiskLargerDiameter_oneDiskTower() {//Cas 3b
		Tour tower = new Tour(3);
		Disque disk1 = new Disque(5);
		Disque disk2 = new Disque(6);
		tower.empiler(disk1);
		//tests
		boolean b = tower.empiler(disk2);
		assertEquals(false, b);
		assertEquals(1, tower.taille());
		assertEquals(5, tower.diam());
	}

	@Test
	public void fullTower_addDiskLargerDiameter_fullTower() {//Cas 3c
		Tour tower = new Tour(3);
		Disque disk1 = new Disque(15);
		Disque disk2 = new Disque(14);
		Disque disk3 = new Disque(13);
		Disque disk4 = new Disque(20);
		tower.empiler(disk1);
		tower.empiler(disk2);
		tower.empiler(disk3);
		//tests
		boolean b = tower.empiler(disk4);
		assertEquals(false, b);
		assertEquals(3, tower.taille());
		assertEquals(13, tower.diam());
	}
}
