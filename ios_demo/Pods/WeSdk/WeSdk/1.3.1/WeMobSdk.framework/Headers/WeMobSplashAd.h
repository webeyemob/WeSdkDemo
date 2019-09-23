//
//  WeMobSplashAd.h
//  WeMobSdk
//
//  Created by Matthew on 2019/8/15.
//  Copyright © 2019年 WeMob. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "WeMobILineItem.h"
#import "WeMobSplashAdDelegate.h"

NS_ASSUME_NONNULL_BEGIN

@interface WeMobSplashAd : NSObject

@property(nonatomic, strong, readonly) NSString *adUnitId;
@property(nonatomic, weak, nullable) id<WeMobSplashAdDelegate> delegate;

-(id)initWithAdUnitId:(NSString *)adUnitId uiWindow:(UIWindow *)uiWindow;

-(void)setBottomView:(UIView *)bottomView;
-(void)setWidth:(int)width height:(int)height;

-(void)loadAd;
-(BOOL)isReady;
-(void)destroy;

@end

NS_ASSUME_NONNULL_END
