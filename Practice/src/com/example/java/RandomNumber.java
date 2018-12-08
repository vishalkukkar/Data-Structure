package com.example.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeMap;

/**
 * After completing, the returned iterator should contain N sorted random
 * numbers. Limit heap space usage to 128 MB.
 */
public class RandomNumber {

	public static void main(String[] args) throws IOException {
		Long count = 0l;
		final long length = 16_000_000_000L;
		try {
			Long start = System.currentTimeMillis();
			System.out.println("max mem "+bytesToMeg(Runtime.getRuntime().maxMemory()));
			System.out.println("free mem "+bytesToMeg(Runtime.getRuntime().freeMemory()));
			Random rand = new Random();
			Iterator<Long> iterator = doIt2(10000000l, rand);

			while (iterator.hasNext()) {
				iterator.next();
				count++;
			}
			System.out.println(count);
			System.out.println(System.currentTimeMillis() - start);
		} catch (Exception e) {
			System.out.println("Exception " + count);
		}
	}

	public static Iterator<Long> doIt2(final long randomsToGenerate, final Random rand) {

		try {
			PriorityQueue<Long> queue = new PriorityQueue<>();
			List<Long> res = new ArrayList<>();
			Long count = 0l;
			
			for (long i = 0; i < randomsToGenerate; i++) {
				count++;
				queue.add(rand.nextLong());
				
				if(count == 1000000){
					System.out.println("got million");
					res.addAll(queue);
					queue = new PriorityQueue<>();
					count = 0l;
					System.gc();
				}
			
			}
			
			return res.iterator();
		} catch (Exception e) {
			System.out.println("e " + e.toString());
		}
		return null;
	}

	public static Iterator<Long> doIt(final long randomsToGenerate, final Random rand) {

		int count = 0;
		try {
			TreeMap<Long, Long> p = new TreeMap<>();
			for (long i = 0; i < randomsToGenerate; i++) {

				if (i % 1000000 == 0) {
					System.out.println("got million");
					count++;
				}
				p.put(rand.nextLong(), 0l);

			}
			return null;
		} catch (Exception e) {
			System.out.println("e " + e.toString() + " count " + count);
		}
		return null;
	}

	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMeg(long bytes) {
		return bytes / MEGABYTE;
	}

}