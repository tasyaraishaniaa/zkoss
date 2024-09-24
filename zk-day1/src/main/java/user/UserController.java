package user;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import java.util.Set;

public class UserController extends SelectorComposer<Component> {

    @Wire
    private Textbox keywordBox;

    @Wire
    private Listbox userListbox;

    @Wire
    private Label idLabel;

    @Wire
    private Label usernameLabel;

    @Wire
    private Label genderLabel;

    @Wire
    private Label birthdateLabel;

    @Wire
    private Label ageLabel;

    @Wire
    private Label provinceLabel;

    @Wire
    private Label cityLabel;

    private ListModelList<User> dataModel = new ListModelList<>();

    private UserService userService = new UserServiceImpl();

    public UserController() {
        dataModel.addAll(userService.findAll());
    }

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        userListbox.setModel(dataModel);
    }

    @Listen("onClick = #searchButton; onOK = window")
    public void search() {
        String keyword = keywordBox.getValue();
        dataModel.clear();
        dataModel.addAll(userService.search(keyword));
    }

    @Listen("onSelect = #userListbox")
    public void showDetail() {
        Set<User> selection = dataModel.getSelection();
        User selected = selection.iterator().next();
        idLabel.setValue("Id: " + selected.getId().toString());
        usernameLabel.setValue("Username: " + selected.getUsername());
        genderLabel.setValue("Gender: " + selected.getGender());
        birthdateLabel.setValue("Birthday: " + selected.getBirthday());
        ageLabel.setValue("Age: " + selected.getAge().toString());
        provinceLabel.setValue("Province: " + selected.getProvince());
        cityLabel.setValue("City: " + selected.getCity());
    }


}
