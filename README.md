# react-native-gps-settings
React Native library to check GPS status and open GPS settings
## Installation

```sh
npm install react-native-gps-settings
```

## Usage

```js
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
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
