import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class ActionPanel extends Panel implements ActionListener{
    private TextButton tbutton;
    public ActionPanel(String buttonLabel){
        super();
        

        this.getPanel().setSize(new Dimension(300,300));
        this.setColor(Color.black);
        tbutton = new TextButton(buttonLabel);
        this.getPanel().add(tbutton.getPanel());
        tbutton.getButton().addActionListener(this);
    }

    public JButton getButton(){
        return this.tbutton.getButton();
    }

    public String getText(){
        return this.tbutton.getText();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
}
