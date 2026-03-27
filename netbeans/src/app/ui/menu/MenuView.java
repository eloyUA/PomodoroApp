
package app.ui.menu;


public interface MenuView {
    void open();
    void close();
    void setEvtHome(Runnable evtHome);
    void setEvtFriendship(Runnable evtFriendship);
    void setEvtHistory(Runnable evtHistory);
}
