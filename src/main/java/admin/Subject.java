package admin;

public interface Subject {
	public void Subscrib(Observer O);
	public void UnSubscrib(Observer O);
	public void NotifyAll();
}
