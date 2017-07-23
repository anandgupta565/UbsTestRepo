package com.ubstest.berlinClock;

import org.junit.Assert;
import org.junit.Test;

import com.ubstest.berlinClock.BerlinClockGeneration;

public class BerlinClockSevenTest {

	BerlinClockGeneration berlinClock = new BerlinClockGeneration();

	@Test
	public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
		Assert.assertEquals("Y", berlinClock.getSeconds(0));
		Assert.assertEquals("O", berlinClock.getSeconds(1));
		Assert.assertEquals("O", berlinClock.getSeconds(59));
	}

	@Test
	public void testTopHoursShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClock.getTopHours(7).length());
	}

	@Test
	public void testTopHoursShouldLightRedLampForEvery5Hours() {
		Assert.assertEquals("OOOO", berlinClock.getTopHours(0));
		Assert.assertEquals("RROO", berlinClock.getTopHours(13));
		Assert.assertEquals("RRRR", berlinClock.getTopHours(23));
		Assert.assertEquals("RRRR", berlinClock.getTopHours(24));
	}

	@Test
	public void testBottomHoursShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClock.getLastRowHours(5).length());
	}

	@Test
	public void testBottomHoursShouldLightRedLampForEveryHourLeftFromTopHours() {
		Assert.assertEquals("OOOO", berlinClock.getLastRowHours(0));
		Assert.assertEquals("RRRO", berlinClock.getLastRowHours(13));
		Assert.assertEquals("RRRO", berlinClock.getLastRowHours(23));
		Assert.assertEquals("RRRR", berlinClock.getLastRowHours(24));
	}

	@Test
	public void testTopMinutesShouldHave11Lamps() {
		Assert.assertEquals(11, berlinClock.getTopMinutes(34).length());
	}

	@Test
	public void testTopMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
		String minutes32 = berlinClock.getTopMinutes(32);
		Assert.assertEquals("R", minutes32.substring(2, 3));
		Assert.assertEquals("R", minutes32.substring(5, 6));
		Assert.assertEquals("O", minutes32.substring(8, 9));
	}

	@Test
	public void testTopMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
		Assert.assertEquals("OOOOOOOOOOO", berlinClock.getTopMinutes(0));
		Assert.assertEquals("YYROOOOOOOO", berlinClock.getTopMinutes(17));
		Assert.assertEquals("YYRYYRYYRYY", berlinClock.getTopMinutes(59));
	}

	@Test
	public void testBottomMinutesShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClock.getLastRowMinutes(0).length());
	}

	@Test
	public void testBottomMinutesShouldLightYellowLampForEveryMinuteLeftFromTopMinutes() {
		Assert.assertEquals("OOOO", berlinClock.getLastRowMinutes(0));
		Assert.assertEquals("YYOO", berlinClock.getLastRowMinutes(17));
		Assert.assertEquals("YYYY", berlinClock.getLastRowMinutes(59));
	}

	@Test
	public void testBerlinClockShouldResultInArrayWith5Elements() {
		Assert.assertEquals(5, berlinClock.getBerlinTime("13:17:01").length);
	}

	@Test
	public void testBerlinClockShouldResultInCorrectSecondsHoursAndMinutes() {
		String[] berlinTime = berlinClock.getBerlinTime("16:37:16");
		String[] expected = new String[] { "Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YYOO" };
		Assert.assertEquals(expected.length, berlinTime.length);
		for (int index = 0; index < expected.length; index++) {
			Assert.assertEquals(expected[index], berlinTime[index]);
		}
	}

}
