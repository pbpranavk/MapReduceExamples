import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LogProcessorMap extends Mapper<Object, LogWritable, Text, IntWritable> {


    public void map(Object key, LogWritable value, Context context)
            throws IOException, InterruptedException {

        context.write(value.getUserIP(), value.getResponseSize());
    }
}