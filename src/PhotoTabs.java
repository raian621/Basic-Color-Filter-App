import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class PhotoTabs extends JTabbedPane {
	ArrayList<Tab> tabList = new ArrayList<>();
	
	public PhotoTabs() {
		tabList.add(new Tab("New Tab"));
		this.add(tabList.get(tabList.size() - 1), "New Tab");
	}
	
	public void addTab(String name) {
		tabList.add(new Tab(name));
		this.add(tabList.get(tabList.size() - 1), name);
	}
	public void removeTab(int i) {
		remove(i);
		tabList.remove(i);
	}
	public void clearTab(int i) {
		tabList.get(i).clear();
	}
	public void loadTab(int i) throws IOException {
		tabList.get(i).load();
	}
	public void saveTab(int i) throws IOException {
		tabList.get(i).save();
	}
	public void addInvertFilter(int i) {
		tabList.add(tabList.get(i).invert());
		this.add(tabList.get(tabList.size() - 1), tabList.get(tabList.size() - 1).name);
	}
	public void addRedFilter(int i) {
		tabList.add(tabList.get(i).seperateRed());
		this.add(tabList.get(tabList.size() - 1), tabList.get(tabList.size() - 1).name);
	}
	public void addGreenFilter(int i) {
		tabList.add(tabList.get(i).seperateGreen());
		this.add(tabList.get(tabList.size() - 1), tabList.get(tabList.size() - 1).name);
	}
	public void addBlueFilter(int i) {
		tabList.add(tabList.get(i).seperateBlue());
		this.add(tabList.get(tabList.size() - 1), tabList.get(tabList.size() - 1).name);
	}

	public void addMonochromeFilter(int i) {
		tabList.add(tabList.get(i).monochrome());
		this.add(tabList.get(tabList.size() - 1), tabList.get(tabList.size() - 1).name);		
	}
}
