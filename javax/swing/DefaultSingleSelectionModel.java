package javax.swing;

import java.io.Serializable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class DefaultSingleSelectionModel implements SingleSelectionModel, Serializable {
  protected ChangeEvent changeEvent = null;
  
  protected EventListenerList listenerList = new EventListenerList();
  
  private int index = -1;
  
  public int getSelectedIndex() { return this.index; }
  
  public void setSelectedIndex(int paramInt) {
    if (this.index != paramInt) {
      this.index = paramInt;
      fireStateChanged();
    } 
  }
  
  public void clearSelection() { setSelectedIndex(-1); }
  
  public boolean isSelected() {
    boolean bool = false;
    if (getSelectedIndex() != -1)
      bool = true; 
    return bool;
  }
  
  public void addChangeListener(ChangeListener paramChangeListener) { this.listenerList.add(ChangeListener.class, paramChangeListener); }
  
  public void removeChangeListener(ChangeListener paramChangeListener) { this.listenerList.remove(ChangeListener.class, paramChangeListener); }
  
  public ChangeListener[] getChangeListeners() { return (ChangeListener[])this.listenerList.getListeners(ChangeListener.class); }
  
  protected void fireStateChanged() {
    Object[] arrayOfObject = this.listenerList.getListenerList();
    for (int i = arrayOfObject.length - 2; i >= 0; i -= 2) {
      if (arrayOfObject[i] == ChangeListener.class) {
        if (this.changeEvent == null)
          this.changeEvent = new ChangeEvent(this); 
        ((ChangeListener)arrayOfObject[i + 1]).stateChanged(this.changeEvent);
      } 
    } 
  }
  
  public <T extends java.util.EventListener> T[] getListeners(Class<T> paramClass) { return (T[])this.listenerList.getListeners(paramClass); }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\javax\swing\DefaultSingleSelectionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */