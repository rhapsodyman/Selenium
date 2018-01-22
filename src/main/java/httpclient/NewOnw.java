package httpclient;

import java.util.ArrayList;
import java.util.List;

public class NewOnw {

	private static final List<String> inProcess = new ArrayList<>();
	
	
	/*if (Holder.get(user == null)) { // null or expired
		if(checkInProcessAndWaitOrTake == true){
				
			try {
				// perform auth operation
				
				Holder.put(user);

			}
			finally {
				removeFromInProcessAndNotifyAll();
			}	
		}
		else {
			Holder.take(user);
		}
	}*/

	public boolean checkInProcessAndWait(String user) throws InterruptedException {

		synchronized (inProcess) {

			int index = inProcess.indexOf(user);
			if (index != -1) {
				inProcess.get(index).wait(); // wait for another thread
				return false;
			} else
				inProcess.add(user); // I will take care of it
			return true;
		}
	}

	public void addToInProcess(String user) {

		synchronized (inProcess) {
			inProcess.add(user);
		}
	}

	public void removeFromInProcessAndNotifyAll(String user) {

		synchronized (inProcess) {
			int index = inProcess.indexOf(user);
			inProcess.get(index).notifyAll();
			inProcess.remove(index);
		}
	}

	public static void main(String args[]) {

	}
}