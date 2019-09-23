//
//  WeMobSplashAdDelegate.h
//  WeMobSdk
//
//  Created by Matthew on 2019/8/15.
//  Copyright © 2019年 WeMob. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "WeMobAdError.h"
@class WeMobSplashAd;

@protocol WeMobSplashAdDelegate<NSObject>

@optional
- (void)weMobSplashDidReceiveAd:(WeMobSplashAd *)splashAd;

@optional
- (void)weMobSplash:(WeMobSplashAd *)splashAd didFailToReceiveAdWithError:(WeMobAdError *)adError;

@optional
- (void)weMobSplashWillPresentScreen:(WeMobSplashAd *)splashAd;

@optional
- (void)weMobSplashDidDismissScreen:(WeMobSplashAd *)splashAd;

@optional
- (void)weMobSplashWillLeaveApplication:(WeMobSplashAd *)splashAd;

@end
