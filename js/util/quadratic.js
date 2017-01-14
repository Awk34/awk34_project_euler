/**
 *
 * @param m2
 * @param n
 * @param x2
 * @returns {number}
 */
export default function quadratic(m2, n, x2) {
    let a = 4 + m2 * m2;
    let b = 2 * m2 * n;
    let c = n * n - 100;

    let ans1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    let ans2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    let dx1 = x2 - ans1;
    let dx2 = x2 - ans2;
    dx1 = dx1 > 0 ? dx1 : -dx1;
    dx2 = dx2 > 0 ? dx2 : -dx2;

    if(dx1 > dx2) return ans1;
    else return ans2;
}
