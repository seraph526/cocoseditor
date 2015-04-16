/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;
import org.ccj.math.Size;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/6/3 12:24 $
 *          $Id$
 */

@Platform(include = "CCPhysicsShape.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsShapeBox extends PhysicsShape
{
    public PhysicsShapeBox(Pointer p)
    {
        super(p);
    }

    public native static PhysicsShapeBox create(@ByRef Size size, @ByRef PhysicsMaterial material, @ByRef Vec2 offset);

    public native static PhysicsShapeBox create(@ByRef Size size, @ByRef PhysicsMaterial material);

    public native static PhysicsShapeBox create(@ByRef Size size);

//    public native static float calculateArea(@ByRef Size size);

//    public native static float calculateMoment(float mass, @ByRef Size size, @ByRef Vec2 offset);

//    public native float calculateDefaultMoment();

    //    public native   void getPoints(Vec2* outPoints) const;
    public native int getPointsCount();

    @ByVal
    public native Size getSize();

    @ByVal
    public native Vec2 getOffset();

    public PhysicsShapeBox cast(Ref ref)
    {
        return cast(ref, PhysicsShapeBox.class);
    }
}
