//
//  WeMobRewardItem.h
//

#import <Foundation/Foundation.h>

@interface WeMobRewardItem : NSObject

@property NSString *rewardType;
@property int rewardAmount;

-(id)initWithType:(NSString *)type andAmount:(int)amount;

@end
