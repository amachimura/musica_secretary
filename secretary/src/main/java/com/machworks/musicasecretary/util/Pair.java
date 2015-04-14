package com.machworks.musicasecretary.util;

/**
 * @author machi_000
 *
 * 2タプルっぽい何か。
 * getメソッドをprotectedにして、wrapしていないものは使えないようにしてみる。
 * pairくらいフランクに使えたほうがいいか…？
 * @param <T1>
 * @param <T2>
 */
public class Pair <T1, T2>{
	private final T1 first;
	private final T2 second;
	
	public Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}
	protected T1 getFirst(){
		return first;
	}
	
	protected T2 getSecond(){
		return second;
	}
}
