package org.launchcode.techjobs.oo.test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Before
    public void createJobObjects() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();

        Assert.assertNotEquals(emptyJob1, emptyJob2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);

        assertTrue(testJob.getName() == "Product tester");

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getEmployer().getValue() == "ACME");

        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getLocation().getValue() == "Desert");

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getPositionType().getValue() == "Quality control");

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob.getCoreCompetency().getValue() == "Persistence");

    }
    @Test
    public void testJobsForEquality() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertNotEquals("false", Job1, Job2);
    }
   @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(testJob.toString().endsWith("\n"));
       assertTrue(testJob.toString().startsWith("\n"));
  }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String output = String.format("\nID:"+testJob.getId()+"\n"+
                                        "Name:"+testJob.getName()+"\n"+
                                         "Employer:"+testJob.getEmployer()+"\n"+
                        "Location:"+testJob.getLocation()+"\n"+
                        "Position Type:"+testJob.getPositionType()+"\n"+
                        "Core Competency:"+testJob.getCoreCompetency()+"\n"
                );
        assertEquals(output,testJob.toString());

        //System.out.println(testJob.toString());

        //assertEquals(lines.length, 1);


    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String output = String.format("\nID:"+testJob.getId()+"\n"+
                "Name:"+testJob.getName()+"\n"+
                "Employer:"+"Data not available"+"\n"+
                "Location:"+testJob.getLocation()+"\n"+
                "Position Type:"+"Data not available"+"\n"+
                "Core Competency:"+testJob.getCoreCompetency()+"\n"
        );
        assertEquals(output,testJob.toString());
    }
}