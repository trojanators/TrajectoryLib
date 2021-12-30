package com.team254.lib.trajectory;

import com.team254.lib.trajectory.io.JavaSerializer;
import com.team254.lib.trajectory.io.JavaStringSerializer;
import com.team254.lib.trajectory.io.TextFileSerializer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jared341
 */
public class Main {
  public static String joinPath(String path1, String path2)
  {
      File file1 = new File(path1);
      File file2 = new File(file1, path2);
      return file2.getPath();
  }
  
  private static boolean writeFile(String path, String data) {
    try {
      File file = new File(path);

      // if file doesnt exists, then create it
      if (!file.exists()) {
          file.createNewFile();
      }

      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(data);
      bw.close();
    } catch (IOException e) {
      return false;
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    String directory = "../2021-Robot-Code/src/main/deploy/paths";
    if (args.length >= 1) {
      directory = args[0];
    }
    
    TrajectoryGenerator.Config config = new TrajectoryGenerator.Config();
    config.dt = .01;
    config.max_acc = 10.0;
    config.max_jerk = 60.0;
    config.max_vel = 15.0;
    
    final double kWheelbaseWidth = .5842;
    {
      config.dt = .01;
      config.max_acc = 1.0;
      config.max_jerk = 10.0;
      config.max_vel = 2.0;
      // Path name must be a valid Java class name.
      final String path_name = "myPath";
      
      // Description of this auto mode path.
      // Remember that this is for the GO LEFT CASE!
      WaypointSequence p = new WaypointSequence(10);
      p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
      p.addWaypoint(new WaypointSequence.Waypoint(7.0, 0, 0));
      p.addWaypoint(new WaypointSequence.Waypoint(14.0, 1.0, Math.PI / 4.0));

      Path path = PathGenerator.makePath(p, config,
          kWheelbaseWidth, path_name);

      // Outputs to the directory supplied as the first argument.
      TextFileSerializer js = new TextFileSerializer();
      String serialized = js.serialize(path);
      //System.out.print(serialized);
      String fullpath = joinPath(directory, path_name + ".csv");
      if (!writeFile(fullpath, serialized)) {
        System.err.println(fullpath + " could not be written!!!!1");
        System.exit(1);
      } else {
        System.out.println("Wrote " + fullpath);
      }
    }
    
    /*{
      config.dt = .01;
      config.max_acc = 8.0;
      config.max_jerk = 50.0;
      config.max_vel = 10.0;
      // Path name must be a valid Java class name.
      final String path_name = "myPath2";
      
      // Description of this auto mode path.
      // Remember that this is for the GO LEFT CASE!
      WaypointSequence p = new WaypointSequence(10);
      p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
      p.addWaypoint(new WaypointSequence.Waypoint(7.0, 0, 0));
      p.addWaypoint(new WaypointSequence.Waypoint(14.0, 5.0, Math.PI / 12.0));

      Path path = PathGenerator.makePath(p, config,
          kWheelbaseWidth, path_name);

      // Outputs to the directory supplied as the first argument.
      TextFileSerializer js = new TextFileSerializer();
      String serialized = js.serialize(path);
      //System.out.print(serialized);
      String fullpath = joinPath(directory, path_name + ".txt");
      if (!writeFile(fullpath, serialized)) {
        System.err.println(fullpath + " could not be written!!!!1");
        System.exit(1);
      } else {
        System.out.println("Wrote " + fullpath);
      }
    }
    
    
    {
      config.dt = .01;
      config.max_acc = 8.5;
      config.max_jerk = 50.0;
      config.max_vel = 12.0;
      // Path name must be a valid Java class name.
      final String path_name = "MyPath3";
      
      // Description of this auto mode path.
      // Remember that this is for the GO LEFT CASE!
      WaypointSequence p = new WaypointSequence(10);
      p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
      p.addWaypoint(new WaypointSequence.Waypoint(7.0, 0, 0));
      p.addWaypoint(new WaypointSequence.Waypoint(15.0, 3, Math.PI / 12.0));

      Path path = PathGenerator.makePath(p, config,
          kWheelbaseWidth, path_name);

      // Outputs to the directory supplied as the first argument.
      TextFileSerializer js = new TextFileSerializer();
      String serialized = js.serialize(path);
      //System.out.print(serialized);
      String fullpath = joinPath(directory, path_name + ".txt");
      if (!writeFile(fullpath, serialized)) {
        System.err.println(fullpath + " could not be written!!!!1");
        System.exit(1);
      } else {
        System.out.println("Wrote " + fullpath);
      }
    }
    
    {
      config.dt = .01;
      config.max_acc = 9.0;
      config.max_jerk = 50.0;
      config.max_vel = 11.75;
      // Path name must be a valid Java class name.
      final String path_name = "myPath4";
      
      // Description of this auto mode path.
      // Remember that this is for the GO LEFT CASE!
      WaypointSequence p = new WaypointSequence(10);
      p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
      p.addWaypoint(new WaypointSequence.Waypoint(14, 0, 0));

      Path path = PathGenerator.makePath(p, config,
          kWheelbaseWidth, path_name);

      // Outputs to the directory supplied as the first argument.
      TextFileSerializer js = new TextFileSerializer();
      String serialized = js.serialize(path);
      //System.out.print(serialized);
      String fullpath = joinPath(directory, path_name + ".txt");
      if (!writeFile(fullpath, serialized)) {
        System.err.println(fullpath + " could not be written!!!!1");
        System.exit(1);
      } else {
        System.out.println("Wrote " + fullpath);
      }
    }
    
     {
      // Path name must be a valid Java class name.
      config.dt = .01;
      config.max_acc = 7.0;
      config.max_jerk = 50.0;
      config.max_vel = 10.0;
      final String path_name = "myPath5";
      
      // Description of this auto mode path.
      // Remember that this is for the GO LEFT CASE!
      WaypointSequence p = new WaypointSequence(10);
      p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
      p.addWaypoint(new WaypointSequence.Waypoint(2.5, 0, 0));
      p.addWaypoint(new WaypointSequence.Waypoint(10.5, 8, Math.PI/12.0));
      p.addWaypoint(new WaypointSequence.Waypoint(13.75, 9.5, 0.0));
      

      Path path = PathGenerator.makePath(p, config,
          kWheelbaseWidth, path_name);

      // Outputs to the directory supplied as the first argument.
      TextFileSerializer js = new TextFileSerializer();
      String serialized = js.serialize(path);
      //System.out.print(serialized);
      String fullpath = joinPath(directory, path_name + ".txt");
      if (!writeFile(fullpath, serialized)) {
        System.err.println(fullpath + " could not be written!!!!1");
        System.exit(1);
      } else {
        System.out.println("Wrote " + fullpath);
      }
    }
*/
  }
}
