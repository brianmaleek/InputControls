# InputControls

ActionSend and EditText dialler design

Coding challenge 2

Challenge: Write code to perform an action directly from the keyboard by tapping a Send key, such as for dialing a phone number:

challenge, create a new app project, and add an EditText that uses the android:inputType attribute set to phone. Use the android:imeOptions attribute for the EditText element with the actionSend value.

In the onCreate() method for this Activity, you can use setOnEditorActionListener() to set the listener for the EditText to detect if the key is pressed

Override onEditorAction() and use the IME_ACTION_SEND constant in the EditorInfo class to respond to the pressed key. In the challenge, the key is used to call the dialNumber() method to dial the phone number.

To finish the challenge, create the dialNumber() method, which uses an implicit intent with ACTION_DIAL to pass the phone number to another app that can dial the number.
