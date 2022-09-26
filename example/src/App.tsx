import * as React from 'react';

import { StyleSheet, View, Text, Button } from 'react-native';
import { isGPSEnabled, openGPSSettings } from 'react-native-gps-settings';

export default function App() {

  const checkGPSStatus = () => {
    isGPSEnabled()
      .then((response) => {
        if (response == true) {
          console.log("GPS already enabled")
        } else {
          openGPSSettings()
        }
      })
  }

  return (
    <View style={styles.container}>
      <Button
        onPress={checkGPSStatus}
        title='Check GPS'>
        <Text>Check GPS</Text>
      </Button>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
