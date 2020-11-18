import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import robot.RobotInterface;

public class HelloAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        RobotInterface.initialize();
    }

}
