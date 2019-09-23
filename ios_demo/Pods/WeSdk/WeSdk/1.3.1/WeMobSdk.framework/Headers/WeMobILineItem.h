//
//  WeMobILinItem.h
//  Created by Matthew on 2019/6/24.
//

#import <Foundation/Foundation.h>
#import "WeMobNetwork.h"
#import "WeMobBannerAdSize.h"

@interface WeMobILineItem : NSObject

-(NSString *)getName;

-(WeMobNetwork *)getNetwork;

-(int)getPriority;

-(float)getEcpm;

-(WeMobBannerAdSize)getBannerAdSize;

-(int)getRequestTimeOut;

-(NSDictionary *)getServerExtras;

@end
