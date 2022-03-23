package view;

import model.VacationDestination;
import model.VacationDestinationPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class TravelAgencyWindow
{
    private JFrame adminFrame = new JFrame("Travel Agency - Admin section");

    private JPanel adminPanel;
    private JPanel vacationDestinationPanel;
    private JPanel vacationPackagesPanel;
    private JPanel vacationDestinationMenuPanel;
    private JPanel packageMenuPanel;

    private JComboBox<VacationDestination> vacationDestinationsList;
    private JComboBox<VacationDestinationPackage> vacationPackagesList;

    private JLabel destinationNameLabel;
    private JTextField destinationNameField;

    private JLabel destinationDescriptionLabel;
    private JTextField destinationDescriptionField;

    private JButton addDestinationButton;
    private JButton deleteDestinationButton;

    private JScrollPane packageDetails;
    private JTextArea packageDetailsArea;

    private JLabel packageNameLabel;
    private JTextField packageNameField;

    private JLabel packagePriceLabel;
    private JTextField packagePriceField;

    private JLabel startDateLabel;
    private JFormattedTextField startDateField;

    private JLabel endDateLabel;
    private JFormattedTextField endDateField;

    private JLabel extraDetailsLabel;
    private JTextField extraDetailsField;

    private JLabel numberOfPeopleLabel;
    private JTextField numberOfPeopleField;

    private JButton addPackageButton;
    private JButton editPackageButton;
    private JButton deletePackageButton;

    private JButton exitButton;

    public TravelAgencyWindow()
    {
        adminFrame.setSize(new Dimension(1000, 1000));

        //main panel - the one that will contain 4 panels
        adminPanel = new JPanel();
        adminPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        adminPanel.setLayout(new GridLayout(2, 2, 10, 10));


        //first panel (row1 col1) - VACATION DESTINATIONS PANEL
        vacationDestinationPanel = new JPanel();
        vacationDestinationPanel.setLayout(new GridLayout(1, 1, 10, 10));
        vacationDestinationPanel.setBorder(BorderFactory.createTitledBorder("Vacation Destinations"));
        //vacationDestinationPanel.setPreferredSize(new Dimension(500, 80));

        //elements to add in the first panel
        vacationDestinationsList = new JComboBox<VacationDestination>();

        //add elements
        vacationDestinationPanel.add(vacationDestinationsList);

        ////////////////////////////////////////////////////////////////////

        //second panel (row1 col2) - VIEW VACATION PACKAGES
        vacationPackagesPanel = new JPanel();
        vacationPackagesPanel.setLayout(new GridLayout(2, 1, 10, 10));
        vacationPackagesPanel.setBorder(BorderFactory.createTitledBorder("Packages available"));

        //elements to add in the first panel
        vacationPackagesList = new JComboBox<VacationDestinationPackage>();

        packageDetailsArea = new JTextArea();
        packageDetailsArea.setEnabled(true);
        packageDetailsArea.setEditable(true);
        packageDetails = new JScrollPane(packageDetailsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //add elements in the panel
        vacationPackagesPanel.add(vacationPackagesList);
        vacationPackagesPanel.add(packageDetails);

        ///////////////////////////////////////////////////////////////////

        //third panel (row2 col1) - VACATION DESTINATIONS MENU PANEL
        vacationDestinationMenuPanel = new JPanel();
        vacationDestinationMenuPanel.setLayout(new GridLayout(3, 2, 10, 10));
        vacationDestinationMenuPanel.setBorder(BorderFactory.createTitledBorder("Destinations Menu"));

        //elements to add in the panel
        destinationNameLabel = new JLabel("Name");
        destinationNameField = new JTextField();

        destinationDescriptionLabel = new JLabel("Short description");
        destinationDescriptionField = new JTextField();

        addDestinationButton = new JButton("add");
        deleteDestinationButton = new JButton("delete");

        //add elements in the panel
        vacationDestinationMenuPanel.add(destinationNameLabel);
        vacationDestinationMenuPanel.add(destinationNameField);
        vacationDestinationMenuPanel.add(destinationDescriptionLabel);
        vacationDestinationMenuPanel.add(destinationDescriptionField);
        vacationDestinationMenuPanel.add(addDestinationButton);
        vacationDestinationMenuPanel.add(deleteDestinationButton);

        ///////////////////////////////////////////////////////////////////

        //last panel (row2 col2) - PACKAGES MENU BUTTONS PANEL
        packageMenuPanel = new JPanel();
        packageMenuPanel.setLayout(new GridLayout(8, 2, 10, 10));
        packageMenuPanel.setBorder(BorderFactory.createTitledBorder("Packages Menu"));

        //elements to add in the panel
        packageNameLabel = new JLabel("Name");
        packageNameField = new JTextField();

        packagePriceLabel = new JLabel("Price");
        packagePriceField = new JTextField();

        startDateLabel = new JLabel("Start Date");
        startDateField = new JFormattedTextField("dd/mm/yyyy");

        endDateLabel = new JLabel("End Date");
        endDateField = new JFormattedTextField("dd/mm/yyyy");

        extraDetailsLabel = new JLabel("Extra Details");
        extraDetailsField = new JTextField();

        numberOfPeopleLabel = new JLabel("Number of possible bookings");
        numberOfPeopleField = new JTextField();

        addPackageButton = new JButton("add");
        editPackageButton = new JButton("edit");
        deletePackageButton = new JButton("delete");
        exitButton = new JButton("EXIT");

        //add elements in the panel
        packageMenuPanel.add(packageNameLabel);
        packageMenuPanel.add(packageNameField);

        packageMenuPanel.add(packagePriceLabel);
        packageMenuPanel.add(packagePriceField);

        packageMenuPanel.add(startDateLabel);
        packageMenuPanel.add(startDateField);

        packageMenuPanel.add(endDateLabel);
        packageMenuPanel.add(endDateField);

        packageMenuPanel.add(extraDetailsLabel);
        packageMenuPanel.add(extraDetailsField);

        packageMenuPanel.add(numberOfPeopleLabel);
        packageMenuPanel.add(numberOfPeopleField);

        packageMenuPanel.add(addPackageButton);
        packageMenuPanel.add(editPackageButton);

        packageMenuPanel.add(deletePackageButton);
        packageMenuPanel.add(exitButton);

        ///////////////////////////////////////////////////////////////////

        //add all the panels in the main one
        adminPanel.add(vacationDestinationPanel);
        adminPanel.add(vacationPackagesPanel);
        adminPanel.add(vacationDestinationMenuPanel);
        adminPanel.add(packageMenuPanel);

        adminFrame.setLayout(new FlowLayout());
        adminFrame.add(adminPanel);
        adminFrame.setVisible(true);
        adminFrame.pack();
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JTextArea getPackageDetailsArea()
    {
        return packageDetailsArea;
    }

    public JScrollPane getPackageDetails()
    {
        return packageDetails;
    }

    public JComboBox<VacationDestination> getVacationDestinationsList()
    {
        return vacationDestinationsList;
    }

    public JComboBox<VacationDestinationPackage> getVacationPackagesList()
    {
        return vacationPackagesList;
    }

    public JTextField getDestinationNameField()
    {
        return destinationNameField;
    }

    public JTextField getDestinationDescriptionField()
    {
        return destinationDescriptionField;
    }

    public JTextField getPackageNameField()
    {
        return packageNameField;
    }

    public JTextField getPackagePriceField()
    {
        return packagePriceField;
    }

    public JFormattedTextField getStartDateField()
    {
        return startDateField;
    }

    public JFormattedTextField getEndDateField()
    {
        return endDateField;
    }

    public JTextField getExtraDetailsField()
    {
        return extraDetailsField;
    }

    public JTextField getNumberOfPeopleField()
    {
        return numberOfPeopleField;
    }

    public void setVisible(boolean b)
    {
        adminFrame.setVisible(b);
    }

    public void addDestinationButtonActionListener(ActionListener actionListener)
    {
        addDestinationButton.addActionListener(actionListener);
    }

    public void deleteDestinationButtonActionListener(ActionListener actionListener)
    {
        deleteDestinationButton.addActionListener(actionListener);
    }

    public void addPackageButtonActionListener(ActionListener actionListener)
    {
        addPackageButton.addActionListener(actionListener);
    }

    public void deletePackageButtonActionListener(ActionListener actionListener)
    {
        deletePackageButton.addActionListener(actionListener);
    }

    public void editPackageButtonActionListener(ActionListener actionListener)
    {
        editPackageButton.addActionListener(actionListener);
    }

    public void exitButtonActionListener(ActionListener actionListener)
    {
        exitButton.addActionListener(actionListener);
    }

    public void addItemListenerPackagesComboBox(ItemListener itemListener)
    {
        vacationDestinationsList.addItemListener(itemListener);
    }

    public void addItemListenerPackagesDetails(ItemListener itemListener)
    {
        vacationPackagesList.addItemListener(itemListener);
    }
}
