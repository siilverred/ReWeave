package edu.uph.m23si2.reweave_charlene;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FormulirDonasi extends Fragment {

    // Declare form fields
    private EditText firstName, lastName, email, phoneNumber, clothesBrand, clothesColor, clothesAge, preferredCallTime, extraInfo;
    private Spinner clothesCondition, clothesType, clothesFabric, clothesSize;
    private CheckBox permissionContact;
    private Button uploadButton, submitButton;
    private TextView dragDropArea, uploadPhotosLabel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_formulir_donasi, container, false);

        // Initialize form fields
        firstName = rootView.findViewById(R.id.first_name);
        lastName = rootView.findViewById(R.id.last_name);
        email = rootView.findViewById(R.id.email);
        phoneNumber = rootView.findViewById(R.id.phone_number);
        clothesBrand = rootView.findViewById(R.id.clothes_brand);
        clothesColor = rootView.findViewById(R.id.clothes_color);
        clothesAge = rootView.findViewById(R.id.clothes_age);
        preferredCallTime = rootView.findViewById(R.id.preferred_call_time);
        extraInfo = rootView.findViewById(R.id.extra_info);

        clothesCondition = rootView.findViewById(R.id.clothes_condition);
        clothesType = rootView.findViewById(R.id.clothes_type);
        clothesFabric = rootView.findViewById(R.id.clothes_fabric);
        clothesSize = rootView.findViewById(R.id.clothes_size);

        permissionContact = rootView.findViewById(R.id.permission_contact);
        uploadButton = rootView.findViewById(R.id.upload_button);
        submitButton = rootView.findViewById(R.id.submit_button);

        dragDropArea = rootView.findViewById(R.id.drag_drop_area);
        uploadPhotosLabel = rootView.findViewById(R.id.upload_photos_label);

        // Setup Spinners
        setupSpinners();

        // Set click listeners
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle file upload (This is just a placeholder for now)
                Toast.makeText(getActivity(), "File upload clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    // Method to setup the Spinners
    private void setupSpinners() {
        // Clothes Condition Spinner
        ArrayAdapter<CharSequence> conditionAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.clothes_condition, android.R.layout.simple_spinner_item);
        conditionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clothesCondition.setAdapter(conditionAdapter);

        // Clothes Type Spinner
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.clothes_type, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clothesType.setAdapter(typeAdapter);

        // Clothes Fabric Spinner
        ArrayAdapter<CharSequence> fabricAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.clothes_fabric, android.R.layout.simple_spinner_item);
        fabricAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clothesFabric.setAdapter(fabricAdapter);

        // Clothes Size Spinner
        ArrayAdapter<CharSequence> sizeAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.clothes_size, android.R.layout.simple_spinner_item);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clothesSize.setAdapter(sizeAdapter);
    }

    private void submitForm() {
        // Gather form data
        String firstNameText = firstName.getText().toString().trim();
        String lastNameText = lastName.getText().toString().trim();
        String emailText = email.getText().toString().trim();
        String phoneNumberText = phoneNumber.getText().toString().trim();
        String clothesBrandText = clothesBrand.getText().toString().trim();
        String clothesColorText = clothesColor.getText().toString().trim();
        String clothesAgeText = clothesAge.getText().toString().trim();
        String preferredCallTimeText = preferredCallTime.getText().toString().trim();
        String extraInfoText = extraInfo.getText().toString().trim();

        // Validate form fields
        if (firstNameText.isEmpty() || lastNameText.isEmpty() || emailText.isEmpty() || phoneNumberText.isEmpty()) {
            Toast.makeText(getActivity(), "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Process form data (e.g., store in database, send to server, etc.)
        // For now, just show a success message
        Toast.makeText(getActivity(), "Donation form submitted successfully!", Toast.LENGTH_SHORT).show();

        // Clear the form after submission
        clearForm();
    }

    private void clearForm() {
        firstName.setText("");
        lastName.setText("");
        email.setText("");
        phoneNumber.setText("");
        clothesBrand.setText("");
        clothesColor.setText("");
        clothesAge.setText("");
        preferredCallTime.setText("");
        extraInfo.setText("");

        clothesCondition.setSelection(0);  // Reset spinner to first item
        clothesType.setSelection(0);
        clothesFabric.setSelection(0);
        clothesSize.setSelection(0);

        permissionContact.setChecked(false);
    }
}
