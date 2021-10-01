import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

import Home from './pages/Home';
import Points from './pages/Points';
import Detail from './pages/Detail';

export type RootStackParamList = {
    Home: undefined;
    Points: {
        uf: string;
        city: string;
    };
    Detail: { point_id: number; };
};

const AppStack = createStackNavigator<RootStackParamList>();

const Routes = () => {
    return (
        <NavigationContainer>
            <AppStack.Navigator screenOptions={{
                cardStyle: {
                    backgroundColor: '#f0f0f5'
                },
                headerShown: false
            }}>
                <AppStack.Screen name="Home" component={Home} />
                <AppStack.Screen name="Points" component={Points} />
                <AppStack.Screen name="Detail" component={Detail} />
            </AppStack.Navigator>
        </NavigationContainer>
    );
};

export default Routes;