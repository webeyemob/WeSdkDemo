//
//  WeMobInteractiveArea.h
//  WeMobSdk
//
//  Created by Matthew on 2019/8/7.
//  Copyright © 2019年 WeMob. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface WeMobInteractiveArea : NSObject

// 将所有元素作为点击区域
+(WeMobInteractiveArea *)allArea;

// 通过 builder.addXxx 将元素添加到点击区域
+(WeMobInteractiveArea *)builder;

// 添加元素到点击区域
-(WeMobInteractiveArea *)addTitle;
-(WeMobInteractiveArea *)addSubTitle;
-(WeMobInteractiveArea *)addBody;
-(WeMobInteractiveArea *)addAdvertiser;
-(WeMobInteractiveArea *)addCallToAction;
-(WeMobInteractiveArea *)addIcon;
-(WeMobInteractiveArea *)addMediaView;
-(WeMobInteractiveArea *)addAdChoices;
-(WeMobInteractiveArea *)addRatingView;
-(WeMobInteractiveArea *)addRatingLabel;
-(WeMobInteractiveArea *)addPrice;
-(WeMobInteractiveArea *)addStore;
-(WeMobInteractiveArea *)addRootView;

// 点击区域是否包括 Xxx
-(BOOL)hasTitle;
-(BOOL)hasSubTitle;
-(BOOL)hasBody;
-(BOOL)hasAdvertiser;
-(BOOL)hasCallToAction;
-(BOOL)hasIcon;
-(BOOL)hasMediaView;
-(BOOL)hasAdChoices;
-(BOOL)hasRatingView;
-(BOOL)hasRatingLabel;
-(BOOL)hasPrice;
-(BOOL)hasStore;
-(BOOL)hasRootView;

@end
