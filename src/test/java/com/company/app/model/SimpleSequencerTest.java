package com.company.app.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleSequencerTest {

	private static final int MILLISECONDS_IN_MINUTE = 60000;

	private Sequencer sequencer;
	
	@Before
	public void setUp() {
		sequencer = new SimpleSequencer();
	}

	public long bpmRunner(int bpm) {
		CountingSequencerObserver countingSequencerObserver = new CountingSequencerObserver();
		sequencer.registerObserver(countingSequencerObserver);
		Thread t = new Thread((SimpleSequencer) sequencer);
		sequencer.setTempoInBPM(bpm);
		sequencer.start();
		t.start();
		try {
			Thread.sleep(MILLISECONDS_IN_MINUTE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sequencer.stop();
		return countingSequencerObserver.getCounter();
	}

	@Test
	public void bpm10beatPerMinuteTest() {
		int expected = 10;
		long actual = bpmRunner(expected);
		Assert.assertTrue((actual <= expected + 1) && (actual >= expected - 1) ? true : false);
	}

	@Test
	public void bpm60beatPerMinuteTest() {
		int expected = 60;
		long actual = bpmRunner(expected);
		Assert.assertTrue((actual <= expected + 2) && (actual >= expected - 2) ? true : false);
	}

	@Test
	public void bpm120beatPerMinuteTest() {
		int expected = 120;
		long actual = bpmRunner(expected);
		Assert.assertTrue((actual <= expected + 3) && (actual >= expected - 3) ? true : false);
	}

	@Test
	public void bpm1000beatPerMinuteTest() {
		int expected = 1000;
		long actual = bpmRunner(expected);
		System.out.println("expected: " + expected + " actual: " + actual);
		Assert.assertTrue((actual <= expected + 50) && (actual >= expected - 50) ? true : false);
	}
	
}
