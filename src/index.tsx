import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-gps-settings' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const GpsSettings = NativeModules.GpsSettings  ? NativeModules.GpsSettings  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );


export async function isGPSEnabled() {
  return GpsSettings.isGPSEnabled();
}
export async function openGPSSettings() {
  return GpsSettings.openGPSSettings();
}