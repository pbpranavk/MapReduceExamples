import java.io.*;
import java.lang.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.util.Hashtable;

public class EmpProcessorReducer extendsReducer<IntWritable, Text, Text, Text>
{
public void reduce(IntWritable key,Iterable<Text> values,Context context)
        throws IOException,InterruptedException
        {
        String empString="",deptString="",gradeString="";String val="";

        for(Text value:values)
        {
        val=value.toString();

        String splitarray[]=val.split(",");
        //if file tag is EF
        //splitarray[0] - file tag
        //splitarray[1] - employee id
        //splitarray[2] - employee name
        //splitarray[3] - salary

        //if file tag is DF
        //splitarray[0] - file tag
        //splitarray[1] - department id
        //splitarray[2] - department name

        If(splitarray[0].equals("EF"))
        {
        empString=splitarray[1].trim()+"\t"+splitarray[2].trim()+"\t"+splitarray[3].trim();
        }else if(splitarray[0].equals("DF"))
        {
        //getting the department name and location
        deptString=splitarray[1].trim()+"\t"+splitarray[2].trim();
        }
        }

        context.write(new Text(key.toString()),new Text(empString+"\t"+deptString));
        //output should be
        // employeeid<tabsperator>employeeName<tabsperator>departmentName
        }
        }
