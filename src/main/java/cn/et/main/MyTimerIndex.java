package cn.et.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import cn.et.model.Mynews;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

public class MyTimerIndex extends TimerTask{
	Mynews my = new Mynews();
	@Override
	public void run(){
		try {
			Configuration cfg = new Configuration();
			cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
			cfg.setObjectWrapper(new DefaultObjectWrapper()); 
			List<Map> list = my.queryNews();
			Map root = new HashMap();
			root.put("newsList", list);		
			freemarker.template.Template temp = cfg.getTemplate("index.ftl");
			String file = "src/main/webapp/index.html";
			Writer out = new OutputStreamWriter(new FileOutputStream(file));
			temp.process(root, out);
			out.flush(); 
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
